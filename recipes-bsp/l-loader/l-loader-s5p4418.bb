DESCRIPTION = "l-loader for s5p4418"
LICENSE = "GPLv2+"

inherit deploy

#SRC_URI = "git://git.nexell.co.kr/nexell/secure/l-loader;protocol=git;branch=nexell"
SRC_URI = "git://github.com/friendlyarm/sd-fuse_s5p4418.git;protocol=https;"
SRCREV = "59b63e7cf746ac52c1d91a6e8aa4155cf2227c0b"

LIC_FILES_CHKSUM = "file://README.md;md5=8dab7ca7cc897736ab2946bdae13b12f"

S = "${WORKDIR}/git"

do_deploy() {
	install -m 0644 ${S}/prebuilt/loader-mmc.img ${DEPLOYDIR}/
#FIXME - hack!  where should this file go?
	install -m 0644 ${S}/prebuilt/bl_mon.img ${DEPLOYDIR}/
}

do_configure() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
