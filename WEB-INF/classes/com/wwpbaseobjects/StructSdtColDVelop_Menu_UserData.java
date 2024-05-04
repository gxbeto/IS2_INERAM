package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColDVelop_Menu_UserData", namespace ="Gregory")
public final  class StructSdtColDVelop_Menu_UserData implements Cloneable, java.io.Serializable
{
   public StructSdtColDVelop_Menu_UserData( )
   {
      this( -1, new ModelContext( StructSdtColDVelop_Menu_UserData.class ));
   }

   public StructSdtColDVelop_Menu_UserData( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColDVelop_Menu_UserData( java.util.Vector<StructSdtDVelop_Menu_UserData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="DVelop_Menu_UserData",namespace="Gregory")
   public java.util.Vector<StructSdtDVelop_Menu_UserData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVelop_Menu_UserData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVelop_Menu_UserData> item = new java.util.Vector<>();
}

