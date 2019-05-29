inherit kernel
require recipes-kernel/linux/linux-yocto.inc

#SRC_URI = "git:///github.com/SamsungARTIK/linux-artik/tree/artik-nexell-4.4;protocol=https;branch=artik-nexell-4.4"
SRC_URI = "git://github.com/jonmason/linux-s5p6818.git;protocol=https;branch=nanopi2-v4.4.y \
	   file://s5p4418_defconfig.patch \
	   file://s5p6818_defconfig.patch \
	  "

SRCREV = "2baec73557c2fe5350160596870f7e1f411c91be"

LINUX_VERSION ?= "4.4.49"

PV = "${LINUX_VERSION}+git${SRCPV}"

LICENSE = "GPLv2 & LGPLv2"

S = "${WORKDIR}/git"

#FIXME - I'm not sure why either of these are needed, but doesn't seem to be functional without them.  Double check the install
do_configure() {
	oe_runmake -C ${S} O=${B} ${KBUILD_DEFCONFIG}
}

do_install_append() {
	install -d ${D}/boot
	make -C ${S} O=${B} ARCH=${MACHINE_ARCH} dtbs || true
	install -m 0644 ${B}/arch/${MACHINE_ARCH}/boot/dts/*.dtb ${D}/boot || true
}
