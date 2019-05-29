DESCRIPTION = "BL1 for s5p4418"
LICENSE = "GPLv2"

inherit deploy

#https://github.com/SamsungARTIK/boot-firmwares-artik530
#SRC_URI = "git://github.com/SamsungARTIK/bl1-artik530;protocol=https;branch=artik"
#SRC_URI = "git://git.nexell.co.kr/nexell/bl1/bl1-s5p4418;protocol=git;branch=nexell"
SRC_URI = "git://github.com/friendlyarm/sd-fuse_s5p4418.git;protocol=https;"
SRCREV = "59b63e7cf746ac52c1d91a6e8aa4155cf2227c0b"

LIC_FILES_CHKSUM = "file://README.md;md5=8dab7ca7cc897736ab2946bdae13b12f"

S = "${WORKDIR}/git"

do_deploy() {
	install -m 0644 ${S}/prebuilt/bl1-mmcboot.bin ${DEPLOYDIR}/
}

do_configure() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
