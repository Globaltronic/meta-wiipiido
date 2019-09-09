DESCRIPTION = "Pine64 Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "4.19"
LINUX_VERSION_EXTENSION = "-wiipiido"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "sunxi64-4.19"
SRCREV = "${AUTOREV}"
SRC_URI = " \
           git://github.com/anarsoul/linux-2.6.git;branch=${BRANCH} \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_wiipiido = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "wiipiido"

