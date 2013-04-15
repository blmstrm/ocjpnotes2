ocjpnotes2
==========

Notes taken while studying for the Oracle Certified Java SE 7 Exam II (1ZO-804). http://goo.gl/LonA0

Using this book: http://www.amazon.com/Certified-Professional-Programmer-1Z0-804-1Z0-805/dp/1430247649
Chapter 3 & 4
-------------
###Notes:
#####Adding Strings and primitive types:
``"Ten" +10+10+10`` turns into ``"Ten101010"`` due to the fact that ``"Ten" + 10`` evaluates to a String variable ``"Ten10"``, which results in ``"Ten10"+10`` also evaluating to a String variable etc.
#####Method overriding:
You can only provide a less restrictive  or same-access modifier when overriding a method.  #####Defining enum elements:
Enum elements  need to be defined first before any other attribute in an enum class.
###Code:
To practice class design I am implementing a generic Tree with the purpose to cover:
  * Interfaces
  * Inheritance
  * Basic OO class design

Link: https://github.com/blmstrm/genericTree

Chapter 5
-------------
###Notes:
No notes here.
###Code:
* Implemented an example of the factory design pattern.
* Implemented an example of a DOA design pattern.

Chapter 6
-------------
###Notes:
Generics where introduces in Java to ensure type safety.

Bounded wildcards, ``<? extends X>``, makes sure that every type ``?`` must extend ``X``. This works with ``super`` as well,``<? super X>``, where ``?`` is a super class of ``X``. It is possible to specify multiple base types ``<? super X & Y>``.

It is not possible to have generic extension classes.

The static method Array.binarySearch(Object []) must be called on an already sorted array to get the desired results.

###Code:
* Implemented a navigableMap example. 

Chapter 7
-------------
###Notes:
To escape characters in regular expressions append ``\`` but to escape characters in ``printf()`` statements use ``%``.

###Code:
No code.

Chapter 8
-------------
###Notes:
No notes.

###Code:
Added code that writes to text files and code that serializes objects to binary files.

Chapter 9
-------------
###Notes:
No notes.

###Code:
No code.

Chapter 10
-------------
###Notes:
Column indexes in a SQL databases starts with 1 and not 0.

###Code:
No code.
