package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;

public final  class gxdomaindvmessagestyling
{
   private static java.util.TreeMap<String, String> domain = new java.util.TreeMap<>();
   static
   {
      domain.put("N", "No Specify");
      domain.put("bootstrap2", "bootstrap2");
      domain.put("boostrap3", "boostrap3");
      domain.put("fontawesome", "fontawesome");
      domain.put("brighttheme", "brighttheme");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

