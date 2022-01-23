# MCEmbeddedLight
MCEmbeddedLight is an assembly that is provided with the minecraft plugin itself as well as rcon-using, lamp-brightness-controlling python application.
The plugin is set to listen to localhost player's light level by default. In order to change the subject of listening, you will need to change listener's parameter in Main.java. Also in current revision you can listen only to a single player at a time.
The python application requests light level(brightness) from the spigot plugin running on your server, when executing(main.py).
**This build was tested on a local server! The python application works only with tapo l530e lightbulb.**

## Installation
Download this repository.
Use the package manager [pip](https://pip.pypa.io/en/stable/) to install following modules.
```bash
pip3 install PyP100
```
PyP100(https://github.com/fishbigger/TapoP100) is used by the assembly to communicate with tp_link tapo l530e bulb.
**During the development of this assembly TapoP100 had an issue, which could lead to wrong behavior!**
As a temporar patch, you can find the line with ```python errorMessage``` in PyL530.py and delete everything until the next ```python def```.

If you don't have python:
  Install python on the official site.

Locate MCEmbeddedLight.jar in plugins folder in your papermc server directory. To do that, move on to Setup section

## Setup
Create config.py in pyreciever with contents:
```python
bulb_ip="ip"
email="email"
password="password"

rcon_ip="ip"
rcon_password="password"
```
To get your bulb_ip use tapo app on your phone.
Fill with your data.

Set your minecraft profile username in Main.java in listener's parameters. Proceed with compiling artifact(.jar will be saved in out directory) [Most likely to be done in IntelliJ]. After that, place the .jar file in plugins.
OR Set your username as user.

## Usage
While running your minecraft server and having your minecraft client connected, execute main.py file in pyreciever folder by double-clicking.
And it will be working. To stop the application, press Ctrl+C(Windows), while having the python script in focus.

## Contributers
absent

## License
[MIT](https://choosealicense.com/licenses/mit/)
