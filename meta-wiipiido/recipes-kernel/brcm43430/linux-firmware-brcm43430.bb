DESCRIPTION = "Firmware nvram for brcm43430."
LICENSE="CLOSED"
# TODO CHANGE LICENSE

COMPATIBLE_MACHINE = "wiipiido"

inherit module

SRC_URI = "file://brcmfmac43430-sdio.txt"

do_configure() {
}

do_compile() {
}

do_install() {
	install -D -m 0644 ${WORKDIR}/brcmfmac43430-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43430-sdio.txt
}

FILES_${PN} = "/lib/firmware/brcm/brcmfmac43430-sdio.txt"

