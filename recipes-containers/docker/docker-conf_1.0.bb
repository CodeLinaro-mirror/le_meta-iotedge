SUMMARY = "Docker configuration files"
HOMEPAGE = "https://www.docker.com"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};\
md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://daemon.json"

do_install () {
    install -d ${D}/data/misc/docker
    install -d ${D}${sysconfdir}/docker
    install -m 0400 ${WORKDIR}/daemon.json ${D}${sysconfdir}/docker/
}

FILES_${PN} += "\
    ${sysconfdir}/docker/* \
    /data/* \
    "
