Stay Awake
---------

Keeps you machine awake and unlocked by making a mouse move at regular interval. Start it when you are not actively using 
your machine.

Stay Awake is:
* Platform independent - Works on OS X, Windows and Linux
* Ultra light - total distribution size around 10 kb
* Self contained - No library dependencies

### Installation

- Make sure we have JRE on machine
- Download the application distribution archive and extract it
- [optional] Add the "<extracted_archives_path>/bin" to `PATH` 


### Usage
* Run the bat (on Windows) or shell file (on OS X / Linux)
    - by double clicking the file
    - or if we have it on PATH, just call the script `stay-awake`
    
* We can optionally pass a number representing interval in seconds. Mouse moves at this interval. Recommended value is between 15 - 90. 

* To stop, press `control+c` 


### Developer Notes

We should have `gradle` locally Change the requires files and then from the project root:

- Simplest way is to run with Gradle `run`
    
    `$ gradle run`

- To run with generated OS specific scripts:
    1. run  
      `gradle clean dZ && cd build/distributions && unzip -o stay-awake.zip && cd -`
  
    2. And then   
      `./build/distributions/stay-awake/bin/stay-awake 10`

- We can run/debug the Main class with IntelliJ Idea or any IDE of our choice as well. 

### LICENSE

```
The MIT License (MIT)

Copyright (c) 2015 Kunal Dabir

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```

### Disclaimer

- Please make sure that usage of this program is in accordance with your organizations security policies.
- While this app is not known to cause any damages, the author(s) of this program shall not be responsible for any such incident.
