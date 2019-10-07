#!/bin/sh -xv

case "$1" in
*)
    java -jar ../target/ParkingLot.jar $1
  ;;
esac



