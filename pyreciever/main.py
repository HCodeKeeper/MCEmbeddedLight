from time import sleep
import config #contains ip, email, password vars. Has to be created manually
from mcrcon import *
import bulb
from mcrcon_manager import mcrcon_manage

def run():
    bulb.run(config, mcrcon_manage)

if __name__ == '__main__':
    run()