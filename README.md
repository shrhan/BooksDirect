# BooksDirect
AppDirect Challenge

This project contains the subscription and user management apis for AppDirect challenge.

The project requires Java 8. It uses H2 memory database. The application runs on 8080 by default. The apis implemented are:

Create subscription 
https://arcane-dawn-24981.herokuapp.com/booksdirect/appdirect/v1/subscription/create?eventUrl={eventUrl}

Change subscription
https://arcane-dawn-24981.herokuapp.com/booksdirect/appdirect/v1/subscription/change?eventUrl={eventUrl}

Cancel subscription
https://arcane-dawn-24981.herokuapp.com/booksdirect/appdirect/v1/subscription/cancel?eventUrl={eventUrl}

Assign user 
https://arcane-dawn-24981.herokuapp.com/booksdirect/appdirect/v1/user/assign?eventUrl={eventUrl}

Unassign user
https://arcane-dawn-24981.herokuapp.com/booksdirect/appdirect/v1/user/unassign?eventUrl={eventUrl}

