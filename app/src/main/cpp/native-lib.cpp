#include <jni.h>
#include <string>
#include <android/log.h>
#include <pthread.h>


extern "C"
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved) {
    return JNI_VERSION_1_6;
}

extern "C"
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM* vm, void* reserved) {
//    VarCache::Release();
}


