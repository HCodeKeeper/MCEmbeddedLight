from PyP100 import PyL530 #pip install PyP100

def formate_default(bulb : PyL530) -> dict:
    info = bulb.getDeviceInfo()['result']
    return {"brightness":info["brightness"], "color_temp":info["color_temp"]}

def restore(bulb : PyL530, default : dict):
    bulb.setBrightness(default["brightness"])
    bulb.setColorTemp(default["color_temp"])

def run(config, func):
    l530 = PyL530.L530(config.bulb_ip, config.email, config.password)
    l530.handshake()
    l530.login()
    l530.turnOn()
    default = formate_default(l530)
    func(config, l530)
    restore(l530, default)