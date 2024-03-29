FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV = "f8c8669760610b2949d8d9ccaeef8231a44d4205"

SRC_URI += "file://boot.txt             \
            file://wiipiido_defconfig   \
	   "

DEPENDS += "arm-trusted-firmware u-boot-tools-native"

do_configure[depends] += "arm-trusted-firmware:do_deploy"

do_configure_prepend() {
    cp ${WORKDIR}/wiipiido_defconfig ${S}/configs/wiipiido_defconfig

    if [ ! -f ${B}/bl31.bin ]; then
        ln ${DEPLOY_DIR}/images/${MACHINE}/bl31-${MACHINE}.bin ${B}/bl31.bin
    fi

    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.txt ${WORKDIR}/boot.scr
}

FILES_${PN} += "/boot/boot.scr"
