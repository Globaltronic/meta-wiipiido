DESCRIPTION = "WIIPIIDO Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "4.19.72"
LINUX_VERSION_EXTENSION = "-wiipiido"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "linux-4.19.y"
SRCREV = "ee809c7e08956d737cb66454f5b6ca32cc0d9f26"
SRC_URI = " \
           git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=${BRANCH} \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_wiipiido = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "wiipiido"

