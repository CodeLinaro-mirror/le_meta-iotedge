DESCRIPTION = "Group of IOT Edge related programs"
LICENSE = "BSD-3-Clause"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

REQUIRED_DISTRO_FEATURES += "virtualization"

IOT_EDGE_BASE = "\
    iotedge-cli \
    iotedge-daemon \
    "

IOT_EDGE_EXTRA = "\
    gstd \
    "

IOT_EDGE_CONF = "\
    docker-conf \
    "

RDEPENDS_${PN} = "\
    ${IOT_EDGE_BASE} \
    ${IOT_EDGE_EXTRA} \
    ${IOT_EDGE_CONF} \
    "
