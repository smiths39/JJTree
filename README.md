JJTree is a preprocessor for JavaCC that inserts parse tree building actions at various places in the JavaCC source.
The output of JJTree is run through JavaCC to create the parser. 

By default JJTree generates code to construct parse tree nodes for each nonterminal in the language. 
This behavior can be modified so that some nonterminals do not have nodes generated, or so that a node is generated for a part of a production's expansion.

JJTree defines a Java interface Node that all parse tree nodes must implement. 
The interface provides methods for operations such as setting the parent of the node, and for adding children and retrieving them.

Although JavaCC is a top-down parser, JJTree constructs the parse tree from the bottom up. 
To do this it uses a stack where it pushes nodes after they have been created.
When it finds a parent for them, it pops the children from the stack and adds them to the parent, and finally pushes the new parent node itself. The stack is open, which means that you have access to it from within grammar actions: you can push, pop and otherwise manipulate its contents however you feel appropriate.
