# Path of the sources
JNI_DIR := $(call my-dir)

LOCAL_PATH := $(JNI_DIR)

# The only real JNI libraries
include $(CLEAR_VARS)
LOCAL_CFLAGS = -DTARGET_ARCH_ABI=\"${APP_ABI}\"
LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog
LOCAL_SRC_FILES := $(wildcard $(LOCAL_PATH)/cpp/*.cpp)
LOCAL_C_INCLUDES := $(LOCAL_PATH)/include/
LOCAL_MODULE = sendfd
include $(BUILD_SHARED_LIBRARY)
Truct Sockaddr* lladdr = Sockaddr_clone(lladdrParm, epAlloc);
