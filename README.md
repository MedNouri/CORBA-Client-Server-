"# CORBA-Client-Server-Example" 
A simple CORBA client server implementation using Java 

Used .idl file 
```

module MiniProjetApp
{
  interface MiniProjet
  {
    double kmh_to_m(in double kilometers);
    double celsius_to_fahrenheit(in double celsius);
    double fahrenheit_to_celsius(in double fahrenheit);
    oneway void shutdown();
    };
};

```

