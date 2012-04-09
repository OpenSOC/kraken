/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_krakenapps_winapi_RegistryKey */

#ifndef _Included_org_krakenapps_winapi_RegistryKey
#define _Included_org_krakenapps_winapi_RegistryKey
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_krakenapps_winapi_RegistryKey
 * Method:    RegOpenKeyEx
 * Signature: (ILjava/lang/String;ILorg/krakenapps/winapi/impl/IntegerRef;)I
 */
JNIEXPORT jint JNICALL Java_org_krakenapps_winapi_RegistryKey_RegOpenKeyEx
  (JNIEnv *, jobject, jint, jstring, jint, jobject);

/*
 * Class:     org_krakenapps_winapi_RegistryKey
 * Method:    RegQueryValueEx
 * Signature: (ILjava/lang/String;Lorg/krakenapps/winapi/impl/IntegerRef;Lorg/krakenapps/winapi/impl/ByteArrayRef;)I
 */
JNIEXPORT jint JNICALL Java_org_krakenapps_winapi_RegistryKey_RegQueryValueEx
  (JNIEnv *, jobject, jint, jstring, jobject, jobject);

/*
 * Class:     org_krakenapps_winapi_RegistryKey
 * Method:    RegCloseKey
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_krakenapps_winapi_RegistryKey_RegCloseKey
  (JNIEnv *, jobject, jint);


JNIEXPORT jint JNICALL Java_org_krakenapps_winapi_RegistryKey_RegQueryInfoKey
  (JNIEnv *, jobject, jint, jobject, jobject, jobject, jobject, jobject, jobject, jobject, jobject);

JNIEXPORT jint JNICALL Java_org_krakenapps_winapi_RegistryKey_RegEnumKeyEx
  (JNIEnv *, jobject, jint, jint, jobject, jint, jobject);

JNIEXPORT jint JNICALL Java_org_krakenapps_winapi_RegistryKey_RegEnumValue
  (JNIEnv *, jobject, jint, jint, jobject, jint);


#ifdef __cplusplus
}
#endif
#endif