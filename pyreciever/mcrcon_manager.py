from mcrcon import *
import light_converter
from time import sleep
import requests

def mcrcon_manage(config, bulb):
    mcr = MCRcon(config.rcon_ip, config.rcon_password)
    #try:
    mcr.connect()
    while(True):
        try:
            sleep(0.1)
            light = mcr.command('getlight')
            if light != "-1":
                level = light_converter.convert(int(light))
                print(light, level)
                bulb.setBrightness(level)
        except requests.exceptions.Timeout:
            print("Timeout occurred")
        except KeyboardInterrupt:
            mcr.disconnect()
            print("Terminating the app")