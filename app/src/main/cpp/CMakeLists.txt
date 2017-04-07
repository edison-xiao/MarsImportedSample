# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

set(lib_src_DIR ${CMAKE_SOURCE_DIR}/${ANDROID_ABI})

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


# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )