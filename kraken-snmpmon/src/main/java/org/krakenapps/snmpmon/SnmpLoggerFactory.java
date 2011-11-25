/*
 * Copyright 2011 Future Systems
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krakenapps.snmpmon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;
import org.krakenapps.log.api.AbstractLoggerFactory;
import org.krakenapps.log.api.IntegerConfigType;
import org.krakenapps.log.api.Logger;
import org.krakenapps.log.api.LoggerConfigOption;
import org.krakenapps.log.api.LoggerSpecification;
import org.krakenapps.log.api.StringConfigType;

/**
 * @author stania
 */
@Component(name = "snmpmon-logger-factory")
@Provides
public class SnmpLoggerFactory extends AbstractLoggerFactory {
	@Override
	public String getName() {
		return "snmpmon";
	}

	@Override
	public Collection<Locale> getDisplayNameLocales() {
		ArrayList<Locale> locales = new ArrayList<Locale>();
		locales.add(Locale.ENGLISH);
		return locales;
	}

	@Override
	public String getDisplayName(Locale locale) {
		return "network usage logger";
	}

	@Override
	public Collection<Locale> getDescriptionLocales() {
		ArrayList<Locale> locales = new ArrayList<Locale>();
		locales.add(Locale.ENGLISH);
		return locales;
	}

	@Override
	public String getDescription(Locale locale) {
		return "network usage logs using SNMP query";
	}

	public enum ConfigOption {
		target("target"), community("community"), version("version"), agents("agents"), hostId("hostId"), port("port");

		String configKey;

		ConfigOption(String configKey) {
			this.configKey = configKey;
		}

		public String getConfigKey() {
			return configKey;
		}
	}

	@Override
	public Collection<LoggerConfigOption> getConfigOptions() {
		List<LoggerConfigOption> types = new ArrayList<LoggerConfigOption>();

		{
			Map<Locale, String> displayNames = new HashMap<Locale, String>();
			displayNames.put(Locale.ENGLISH, "Targets(IP:PORT format)");
			displayNames.put(Locale.KOREAN, "대상 에이전트 주소(IP:PORT 형식)");

			Map<Locale, String> descriptions = new HashMap<Locale, String>();
			descriptions.put(Locale.ENGLISH, "Addresses of target network agents");
			descriptions.put(Locale.KOREAN, "대상 네트워크 장비의 주소들");

			types.add(new StringConfigType(ConfigOption.target.toString(), displayNames, descriptions, true));
		}

		{
			Map<Locale, String> displayNames = new HashMap<Locale, String>();
			displayNames.put(Locale.ENGLISH, "Community string");
			displayNames.put(Locale.KOREAN, "Community 문자열");

			Map<Locale, String> descriptions = new HashMap<Locale, String>();
			descriptions.put(Locale.ENGLISH, "Community string of target device(ex: public). ");
			descriptions.put(Locale.KOREAN, "대상 네트워크 장비의 Community 문자열(예: public). ");

			types.add(new StringConfigType(ConfigOption.community.toString(), displayNames, descriptions, true));
		}

		{
			Map<Locale, String> displayNames = new HashMap<Locale, String>();
			displayNames.put(Locale.ENGLISH, "SNMP version");
			displayNames.put(Locale.KOREAN, "SNMP 버전");

			Map<Locale, String> descriptions = new HashMap<Locale, String>();
			descriptions.put(Locale.ENGLISH, "SNMP version accepted by target agent. ");
			descriptions.put(Locale.KOREAN, "대상 장비가 인식하는 SNMP 버전. " + "기본값 v2c");

			types.add(new IntegerConfigType(ConfigOption.version.toString(), displayNames, descriptions, false));
		}

		return types;
	}

	public Logger createLogger(String name, String description, Properties config) {
		return new SnmpLogger("local", name, description, this, config);
	}

	@Override
	protected Logger createLogger(LoggerSpecification spec) {
		return new SnmpLogger(spec.getNamespace(), spec.getName(), spec.getDescription(), this, spec.getConfig());
	}
}
