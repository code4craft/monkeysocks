#!/bin/bash
#
# * Copyright 2008 Google Inc.
# *
# * This program is free software; you can redistribute it and/or
# * modify it under the terms of the GNU General Public License
# * as published by the Free Software Foundation; either version 2
# * of the License, or (at your option) any later version.
# *
# * This program is distributed in the hope that it will be useful,
# * but WITHOUT ANY WARRANTY; without even the implied warranty of
# * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# * GNU General Public License for more details.
# *
# * You should have received a copy of the GNU General Public License
# * along with this program; if not, write to the Free Software
# * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
#
# Runs test client with appropriate class path.

JSOCKS_HOME=`pwd`

export JAVA_HOME=/home/build/buildtools/java/jdk1.6.0
export PATH=$JAVA_HOME/bin/:$PATH
export CLASSPATH=$JSOCKS_HOME/jsocks-server.jar:$JSOCKS_HOME/jsocks-client.jar:$JSOCKS_HOME/third-party/apache-log4j/log4j-1.2.15.jar:$JSOCKS_HOME/build/prod/classes

java -classpath $CLASSPATH net.sourceforge.jsocks.SOCKS $*
