DESCRIPTION = "Standard mode libiothsm implementation for Azure IoT Edge"
LICENSE = "MIT"

LIC_FILES_CHKSUM=" \
file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8 \
"

BRANCH = "release/1.0.9"
SRCREV = "1f7cf6a21dfa365c8f21475553c544f4df02dd44"

SRC_URI += "gitsm://github.com/azure/iotedge.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git/edgelet/hsm-sys/azure-iot-hsm-c"

do_configure_prepend() {
    cd ${WORKDIR}/git
    git submodule update --init --recursive
}

DEPENDS += "openssl"
PROVIDES += "virtual/libiothsm"
RPROVIDES_${PN} += "virtual/libiothsm"

EXTRA_OECMAKE += "-DBUILD_SHARED=On -Duse_emulator=Off -Duse_http=Off -Duse_default_uuid=On -DCMAKE_SYSTEM_VERSION=10"
inherit cmake
