setenv bootargs console=tty0 console=ttyS0,115200 earlyprintk root=/dev/mmcblk0p2 rootwait

fatload mmc 0 $ramdisk_addr_r fitImage

bootm $ramdisk_addr_r
