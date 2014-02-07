Velocity Terminal
========


The main purpose of the project is to provide a pure Java terminal emulator that supports panes and
tabs as well as storing connection info for ease of opening terminals.

This was forked from JediTerm the goal of creating a standalone cross platform ssh connection
client similar to Gnome Connection Manager http://kuthulu.com/gcm/.

As much as possible I plan to reuse the code from JediTerm rather than forking the code. I hope to
build a cool ui on top of JediTerm and contribute any improvements to JediTerm core back to
JediTerm (if they want them).  At a later date I will look at including the JediTerm code as a
jar rather than maintaing a separate copy.


Authors
-------

Daryl Handley <darylhandley72@yahoo.com>


License
-------
Licensed under LGPL.


Features
--------

* Ssh using JSch from jcraft.org 
* Local terminal using Pty4J
* Xterm emulation
* Xterm 256 colours
* Scrolling
* Copy/Paste
* Mouse support
* Terminal resizing from client or server side
* Terminal tabs


Links
-----
 * Terminal protocol description: http://invisible-island.net/xterm/ctlseqs/ctlseqs.html
 * Terminal Character Set Terminology and Mechanics: http://www.columbia.edu/kermit/k95manual/iso2022.html
 * VT420 Programmer Reference Manual: http://manx.classiccmp.org/collections/mds-199909/cd3/term/vt420rm2.pdf
 * Pty4J library: https://github.com/traff/pty4j
 * JSch library: http://www.jcraft.com/jsch
 * UTF8 Demo: http://www.cl.cam.ac.uk/~mgk25/ucs/examples/UTF-8-demo.txt
 * Control sequences visualization: http://www.gnu.org/software/teseq/


Usages
------

Standalone java app.


Origin
------
Contined as a fork of JediTerm  Dmitry Trofimov <dmitry.trofimov@jetbrains.com>, Clément Poulain

which was in turn

Continued as a fork of Gritty (http://code.google.com/p/gritty) by Robert Wittams
and Omer Kudat, which was in its own turn a rework of
JCTerm(http://www.jcraft.com/jcterm) by Atsuhiko Yamanaka

Character sets designation and mapping implementation is based on 
respective classes from jVT220 (https://github.com/jawi/jVT220, Apache 2.0 licensed) by J.W. Janssen
