DESCRIPTION = "WIIPIIDO Linux Kernel v5.2"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.2.7"
LINUX_VERSION_EXTENSION = "-wiipiido"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "sunxi64-5.2.y"
SRCREV = "be246e6a6a8163d760e4badf1402f17ba974f4d7"
SRC_URI = " \
           git://github.com/anarsoul/linux-2.6.git;branch=${BRANCH} \
           file://sun50i-a64-wiipiido.dts \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_wiipiido = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "wiipiido"

do_configure_prepend() {
    cp ${WORKDIR}/sun50i-a64-wiipiido.dts ${S}/arch/arm64/boot/dts/allwinner/sun50i-a64-wiipiido.dts
}
