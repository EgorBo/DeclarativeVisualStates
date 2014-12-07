DeclarativeVisualStates
=======================

Imagine we have a view of some user's profile and this view may be sligtly different depending on current user's role (guest, member or moderator), in other words the view has three similiar states:

![Alt text](http://habrastorage.org/files/c1b/99f/e6c/c1b99fe6c83244768637b0323c5b252b.png)

How will you design it? Three different activities? Extract common UI into fragments? One single layout and control visibility via code? I suggest a solution where you can declare those states in a single layout xml file and just call goToState(i.e. "Moderator") in code (moving shit from code into xml). This approach is similiar to C# VisualStateManager we have in XAML world.

Code now looks clean!

![Alt text](http://habrastorage.org/files/882/d0a/dc1/882d0adc184f4d45997476d1c22650ca.png)

Xml:

![Alt text](http://habrastorage.org/files/34e/a1b/7ec/34ea1b7ecd224db9bbd917349b52d646.png)
