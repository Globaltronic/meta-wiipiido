DESCRIPTION = "WIIPIIDO Linux Kernel v4.19"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "4.19.73"
LINUX_VERSION_EXTENSION = "-wiipiido"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "linux-4.19.y"
SRCREV = "db2d0b7c1dde59b93045a6d011f392fb04b276af"
SRC_URI = " \
           git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=${BRANCH} \
           file://sun50i-a64-wiipiido.dts \
           file://extra.cfg \
           file://fragment.cfg \
	  "

KBUILD_DEFCONFIG_wiipiido = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "wiipiido"

#do_configure_prepend() {
#    cp ${WORKDIR}/sun50i-a64-wiipiido.dts ${S}/arch/arm64/boot/dts/allwinner/sun50i-a64-wiipiido.dts
#}
