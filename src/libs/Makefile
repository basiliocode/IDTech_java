SHELL = /bin/sh
INCLUDE = \
    -I../usr/include/sys \
    -I../Headers


ifeq ($(CROSSCOMPILE), TRUE)
#CC=i686-w64-mingw32-gcc -Wl,--stack,100000000 -I/lib/ -w  -fmessage-length=0 -fPIC -lstdc++
CC=i686-w64-mingw32-gcc -Wl,--stack,33554432 -I/lib/ -w  -fmessage-length=0 -fPIC -lstdc++
else
#CC=mingw32-gcc -Wl,--stack,100000000 -I/lib/ -w  -fmessage-length=0 -fPIC -lstdc++
CC=mingw32-gcc -Wl,--stack,33554432 -I/lib/ -w  -fmessage-length=0 -fPIC -lstdc++
endif
CCDEPMODE =
CFLAGS =  -g -O2
CPP =
CPPFLAGS =

DEMO = ../../../C++_Demo_Source
SDKCOMP = ../../../C++_Demo
DEMOCOMP = ../../../C++_SDK
CXX = g++  -I/lib/ -w -c -fmessage-length=0 -fPIC -lstdc++
CXXCPP =
CXXDEPMODE = depmode=gcc3
CXXFLAGS =  -g -O2

FLAGS        = -std=gnu99 -Iinclude
DEBUGFLAGS   = -O0 -D _DEBUG
RELEASEFLAGS = -O2 -D NDEBUle:29: *** missing sepG -combine -fwhole-program

LDFLAGS =  -L$(SDKCOMP)/Windows -L. -static -static-libgcc -static-libstdc++  -lpthread -lAugustaHID -lMiniSmartII -lL100 -lKioskIII -lSpectrumPro -lUniPayI_V -lVP3300_AJ -lVP3300_USB -lVP3300_BT -lVP8800 -lVendi -lNEO2 -lIDTechSDK

LIBOBJS =
LIBS =
LIBTOOL =

TARGET  = IDTechSDK_Demo.exe
SOURCES = $(shell echo ../*.c)
HEADERS = $(shell echo ../*.h)

OTHERDEMOS := $(wildcard ../../*_Demo/Windows)

CSRCS = $(wildcard ../*.c)

CPPSRCS = $(wildcard ../*.cpp)

COBJS := $(CSRCS:.c=.o)

CPPOBJS := $(CPPSRCS:.cpp=.o)

PREFIX = $(DESTDIR)/usr/local
BINDIR = $(PREFIX)/bin

all: $(OTHERDEMOS) $(TARGET)
clean:
	rm -f $(COBJS) $(CPPOBJS) $(TARGET)
$(TARGET) : $(COBJS) $(CPPOBJS)


	$(CC) -o $(TARGET) $(COBJS) $(CPPOBJS) $(LIBS) -o $@ $(LDFLAGS)


	rm -f $(SDKCOMP)/Windows/$(TARGET)
	cp $(TARGET) $(SDKCOMP)/Windows/
	rm -f $(DEMO)/SDK_Demo_Main/$(TARGET)
	cp $(TARGET) $(DEMO)/SDK_Demo_Main/
	cp ../NEO2_Devices.xml $(SDKCOMP)/Windows/
	cp ../ca-certificates.crt $(SDKCOMP)/Windows/


	rm -f *.o
	rm -f ../*.o

$(OTHERDEMOS):
	$(MAKE) -C $@ clean && $(MAKE) -C $@

.PHONY: all $(OTHERDEMOS)
