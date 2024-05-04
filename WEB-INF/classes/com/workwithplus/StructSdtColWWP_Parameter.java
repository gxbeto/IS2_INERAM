package com.workwithplus ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWP_Parameter", namespace ="Gregory")
public final  class StructSdtColWWP_Parameter implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_Parameter( )
   {
      this( -1, new ModelContext( StructSdtColWWP_Parameter.class ));
   }

   public StructSdtColWWP_Parameter( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtColWWP_Parameter( java.util.Vector<StructSdtWWP_Parameter> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWP_Parameter",namespace="Gregory")
   public java.util.Vector<StructSdtWWP_Parameter> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_Parameter> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_Parameter> item = new java.util.Vector<>();
}

