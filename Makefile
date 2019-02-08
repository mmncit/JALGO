# references: 
#      1. https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html
#      2. http://profesores.elo.utfsm.cl/~agv/elo329/Java/javamakefile.html
#      3. https://www.cs.odu.edu/~tkennedy/cs350/s17-tkennedy/Public/make/index.html
#
 
JC = javac
JVM = java
JOPTIONS = -g
LIB = JUNIT/junit-4.13-beta-1.jar

.SUFFIXES: .java .class

.java.class:
		$(JC) -g -cp $(LIB) $*.java $<

CLASSES = \
		algorithms/*.java \
		Math.java \
		Time.java \
	
PKGSRC = datastructure

default: classes Main.class $(PKGSRC)/*.class

classes: $(CLASSES:.java=.class)

$(PKGSRC)/%.class: $(PKGSRC)/%.java
		$(JC) $(JOPTIONS) -cp $(LIB) $(PKGSRC)/$*.java $<

Main.class: Main.java
		$(JC) $(JOPTIONS) Main.java

clean:
		$(RM) *.class
