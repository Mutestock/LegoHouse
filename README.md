## LegoHouse

This is a solution to a mandatory educational project. 

IMPORTANT:

Due to the recent confusion about the deadline of this project, I've made an edition of it which assumes that the deadline is 25/05/19 23:55 instead of 24/05/19 23:55.

This version is designated as: legohouseDeadline25th

If the deadline was, in fact, NOT the 25th and instead the 24th, then please use the standard folder, which was last updated on the 24th deadline. Look at the commit log if in doubt. Target location of old folder changed due to moving of project group in netbeans. This was in order to avoid confusion between old and new project.


Changes that was planned to be in the 25th edition are:

* Inclusion and usage of custom exceptions
* Correcting errors
* Attempts at increasing program performance
* Improving code readability
* Comments
* Update facade
* A few other nitpicky things.

Ended up accidentally rolling back some code that I couldn't regain. means that cancelled, delivered etc stopped working.





Also note, that the connection to the server database has been slow. Upon transferring the database data from localhost to said database, the now deprecated JUnit tests completion time increased from under 1 second to over 23. It's noticeable especially when creating an order on the site, since the site attempts to find an empty spot for an order id with an ArrayList, which does not use any sortation method. One could invest more time into optimization, but it's been unprioritized due to the deadline.

Frontend graphics has been unprioritized as well. 




