DESCRIPTION = "Standard mode libiothsm implementation for Azure IoT Edge"
LICENSE = "MIT"

LIC_FILES_CHKSUM=" \
file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8 \
"

BRANCH = "master"
SRCREV = "a4ae2c116296ad086a9f2cb7ccd2f077c5692301"

SRC_URI += "gitsm://github.com/azure/iotedge.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git/edgelet/hsm-sys/azure-iot-hsm-c"

do_checkout() {
    cd ${WORKDIR}/git
    git checkout 1.0.9
    git submodule update --init --recursive
}

addtask do_checkout after do_unpack before do_populate_lic do_patch

DEPENDS += "openssl"
PROVIDES += "virtual/libiothsm"
RPROVIDES_${PN} += "virtual/libiothsm"

EXTRA_OECMAKE += "-DBUILD_SHARED=On -Duse_emulator=Off -Duse_http=Off -Duse_default_uuid=On -DCMAKE_SYSTEM_VERSION=10"
inherit cmake
