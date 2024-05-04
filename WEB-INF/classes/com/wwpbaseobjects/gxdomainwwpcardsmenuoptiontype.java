package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;

public final  class gxdomainwwpcardsmenuoptiontype
{
   private static java.util.TreeMap<Byte, String> domain = new java.util.TreeMap<>();
   static
   {
      domain.put((byte)1, "Icon And Title");
      domain.put((byte)2, "Progress Bar");
      domain.put((byte)3, "Progress Circle");
      domain.put((byte)4, "Custom Web Component");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        byte key )
   {
      if (domain.containsKey( key ))
      {
         return domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Byte> getValues( )
   {
      GXSimpleCollection<Byte> value = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Byte) itr.next());
      }
      return value;
   }

}

