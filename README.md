# MessageCroppingAlgorithm
Message Cropping Algorithm as part of assignment

Rules:

Method receives two arguments:
- A String (message)
- An int (K)

The message has the following rules:
- Message will be alphanumeric
- Message will not start with spaces
- message will not have more than one space between letters


The method should limit the message to the number of characters equal to K. However:
- The message cannot be cut off within a word. 
- The message must end on a whole word. 
- The message must not end on a space.

Example: 

public String calculateValidMessage("The quick brown fox jumpes over the lazy dog", 39) {...}; must return:

 "The quick brown fox jumpes over the lazy"