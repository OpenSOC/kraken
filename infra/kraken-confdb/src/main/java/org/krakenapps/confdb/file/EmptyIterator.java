package org.krakenapps.confdb.file;

import java.util.ArrayList;
import java.util.Collection;

import org.krakenapps.api.PrimitiveParseCallback;
import org.krakenapps.confdb.Config;
import org.krakenapps.confdb.ConfigIterator;
import org.krakenapps.confdb.ConfigParser;

class EmptyIterator implements ConfigIterator {
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Config next() {
		return null;
	}

	@Override
	public void remove() {
	}

	@Override
	public void setParser(ConfigParser parser) {
	}

	@Override
	public Collection<Object> getDocuments() {
		return new ArrayList<Object>();
	}

	@Override
	public <T> Collection<T> getDocuments(Class<T> cls) {
		return new ArrayList<T>();
	}

	@Override
	public <T> Collection<T> getDocuments(Class<T> cls, PrimitiveParseCallback callback) {
		return new ArrayList<T>();
	}

	@Override
	public void close() {
	}
}