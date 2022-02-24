DESCRIPTION = "Standard mode libiothsm implementation for Azure IoT Edge"
LICENSE = "MIT"

LIC_FILES_CHKSUM=" \
file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8 \
"

BRANCH = "main"
SRCREV = "e5691ce2f6da11ab95bb87f1e064f7cee917b257"

SRC_URI += "git://source.codeaurora.org/quic/le/iotedge.git;protocol=https;branch=iotedge/${BRANCH}"

S = "${WORKDIR}/git/edgelet/hsm-sys/azure-iot-hsm-c"

do_checkout() {
    cd ${WORKDIR}/git
    git checkout e5691ce2f6da11ab95bb87f1e064f7cee917b257
    git submodule update --init --recursive
}

addtask do_checkout after do_unpack before do_populate_lic do_patch

DEPENDS += "openssl"
PROVIDES += "virtual/libiothsm"
RPROVIDES_${PN} += "virtual/libiothsm"

EXTRA_OECMAKE += "-DBUILD_SHARED=On -Duse_emulator=Off -Duse_http=Off -Duse_default_uuid=On -DCMAKE_SYSTEM_VERSION=10"
inherit cmake
