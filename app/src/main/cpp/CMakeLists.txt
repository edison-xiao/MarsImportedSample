
cmake_minimum_required(VERSION 3.4.1)

set(lib_src_DIR ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})

add_library(
            native-lib
            SHARED
            native-lib.cpp
            )

add_library(
            marsxlog
            SHARED
            IMPORTED
            )

set_target_properties(
            marsxlog
            PROPERTIES IMPORTED_LOCATION
            ${lib_src_DIR}/libmarsxlog.so
            )

add_library(
            stlport_shared
            SHARED
            IMPORTED
            )
set_target_properties(
            stlport_shared
            PROPERTIES IMPORTED_LOCATION
            ${lib_src_DIR}/libstlport_shared.so
            )
add_library(
            marsstn
            SHARED
            IMPORTED
            )
set_target_properties(
            marsstn
            PROPERTIES IMPORTED_LOCATION
            ${lib_src_DIR}/libmarsstn.so
)



find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )


target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )