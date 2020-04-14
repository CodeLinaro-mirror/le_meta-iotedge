DEPENDS += "openssl virtual/libiothsm"

export OPENSSL_DIR = "${STAGING_EXECPREFIXDIR}"
export OPENSSL_LIB_DIR = "${STAGING_LIBDIR}"
export LIBIOTHSM_NOBUILD="On"

do_install () {
    # Binaries
    install -d  "${D}${bindir}"
    install -m 755 "${WORKDIR}/git/edgelet/target/${CARGO_TARGET_SUBDIR}/iotedge" ${D}${bindir}/iotedge
}
