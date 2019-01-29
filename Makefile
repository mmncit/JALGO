# ref: https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html
#      http://profesores.elo.utfsm.cl/~agv/elo329/Java/javamakefile.html
#      https://www.cs.odu.edu/~tkennedy/cs350/s17-tkennedy/Public/make/index.html
#

#
# Define compiler and compiler options
# define a variable for the compiler (JC)  
# define a variable for the Java Virtual Machine (JVM)
# 
JC = javac
JOPTIONS = -g
JVM = java
LIB = JUNIT/junit-4.13-beta-1.jar

#
# Clear any default targets for building .class files from .java files; we 
# will provide our own target entry to do this in this makefile.
# make has a set of default targets for different suffixes (like .c.o) 
# Currently, clearing the default for .java.class is not necessary since 
# make does not have a definition for this target, but later versions of 
# make may, so it doesn't hurt to make sure that we clear any default 
# definitions for these
#
.SUFFIXES: .java .class

#
# Here is the target entry for creating .class files from .java files 
# This is a target entry that uses the suffix rule syntax:
#	DSTS:
#		rule
#  'TS' is the suffix of the target file, 'DS' is the suffix of the dependency 
#  file, and 'rule'  is the rule for building a target	
# '$*' is a built-in macro that gets the basename of the current target 
# Remember that there must be a < tab > before the command line ('rule') 
#
.java.class:
		$(JC) -cp $(LIB) $(JOPTIONS) $*.java $<

#
# CLASSES is a macro consisting of N words (one for each java source file)
# When a single line is too long, use \<return> to split lines that then will be
# considered as a single line. For example:
# NAME = Camilo \
         Juan 
# is understood as
# NAME = Camilo        Juan
CLASSES = datastructure/Queue.java \
		Math.java \
		Time.java \
	
#
# the default make target entry
# for this example it is the target classes
#
default: classes Main.class

#
# This target entry uses Suffix Replacement within a macro: 
# $(name:string1=string2)
# 	In the words in the macro named 'name' replace 'string1' with 'string2'
# Below we are replacing the suffix .java of all words in the macro CLASSES 
# with the .class suffix
#
classes: $(CLASSES:.java=.class)

Main.class: Main.java
		$(JC) $(JOPTIONS) Main.java

# this line is to remove all unneeded files from
# the directory when we are finished executing(saves space)
# and "cleans up" the directory of unneeded .class files
# RM is a predefined macro in make (RM = rm -f)
#
clean:
		$(RM) *.class
