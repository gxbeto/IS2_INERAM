package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;

public final  class gxdomaindvmessagetype
{
   private static java.util.TreeMap<String, String> domain = new java.util.TreeMap<>();
   static
   {
      domain.put("notice", "Regular");
      domain.put("info", "Information");
      domain.put("success", "Success");
      domain.put("error", "Error");
      domain.put("nospecify", "No specify");
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

