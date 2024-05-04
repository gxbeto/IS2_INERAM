package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWP_DesignSystemSettings", namespace ="Gregory")
public final  class StructSdtColWWP_DesignSystemSettings implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_DesignSystemSettings( )
   {
      this( -1, new ModelContext( StructSdtColWWP_DesignSystemSettings.class ));
   }

   public StructSdtColWWP_DesignSystemSettings( int remoteHandle ,
                                                ModelContext context )
   {
   }

   public  StructSdtColWWP_DesignSystemSettings( java.util.Vector<StructSdtWWP_DesignSystemSettings> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWP_DesignSystemSettings",namespace="Gregory")
   public java.util.Vector<StructSdtWWP_DesignSystemSettings> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_DesignSystemSettings> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_DesignSystemSettings> item = new java.util.Vector<>();
}

