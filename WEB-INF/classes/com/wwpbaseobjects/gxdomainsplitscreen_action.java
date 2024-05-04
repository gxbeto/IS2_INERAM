package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;

public final  class gxdomainsplitscreen_action
{
   private static java.util.TreeMap<Byte, String> domain = new java.util.TreeMap<>();
   static
   {
      domain.put((byte)1, "Go To");
      domain.put((byte)2, "Go Back");
      domain.put((byte)3, "Record Created");
      domain.put((byte)4, "Record Deleted");
      domain.put((byte)5, "Record Updated");
      domain.put((byte)6, "Record Creation Canceled");
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

