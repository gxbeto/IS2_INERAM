package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "HomeModulesSDT", namespace ="Gregory")
public final  class StructSdtHomeModulesSDT implements Cloneable, java.io.Serializable
{
   public StructSdtHomeModulesSDT( )
   {
      this( -1, new ModelContext( StructSdtHomeModulesSDT.class ));
   }

   public StructSdtHomeModulesSDT( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtHomeModulesSDT( java.util.Vector<StructSdtHomeModulesSDT_HomeModulesSDTItem> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="HomeModulesSDTItem",namespace="Gregory")
   public java.util.Vector<StructSdtHomeModulesSDT_HomeModulesSDTItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtHomeModulesSDT_HomeModulesSDTItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtHomeModulesSDT_HomeModulesSDTItem> item = new java.util.Vector<>();
}

