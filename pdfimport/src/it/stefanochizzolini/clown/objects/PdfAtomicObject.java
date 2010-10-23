/*
  Copyright 2006-2009 Stefano Chizzolini. http://clown.stefanochizzolini.it

  Contributors:
    * Stefano Chizzolini (original code developer, http://www.stefanochizzolini.it)

  This file should be part of the source code distribution of "PDF Clown library"
  (the Program): see the accompanying README files for more info.

  This Program is free software; you can redistribute it and/or modify it under the terms
  of the GNU Lesser General Public License as published by the Free Software Foundation;
  either version 3 of the License, or (at your option) any later version.

  This Program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY,
  either expressed or implied; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the License for more details.

  You should have received a copy of the GNU Lesser General Public License along with this
  Program (see README files); if not, go to the GNU website (http://www.gnu.org/licenses/).

  Redistribution and use, with or without modification, are permitted provided that such
  redistributions retain the above copyright notice, license and disclaimer, along with
  this list of conditions.
*/

package it.stefanochizzolini.clown.objects;

/**
  Abstract PDF atomic object.

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @version 0.0.8
*/
public abstract class PdfAtomicObject<TValue>
  extends PdfDirectObject
{
  // <class>
  // <dynamic>
  // <fields>
  private TValue value;
  // </fields>

  // <constructors>
  public PdfAtomicObject(
    )
  {}
  // </constructors>

  // <interface>
  // <public>
  /**
    Gets the low-level representation of the value.
  */
  public TValue getRawValue(
    )
  {return value;}

  /**
    Gets the high-level representation of the value.
  */
  public Object getValue(
    )
  {return value;}

  /**
    Sets the low-level representation of the value.
  */
  public void setRawValue(
    TValue value
    )
  {this.value = value;}

  /**
    Sets the high-level representation of the value.
  */
  @SuppressWarnings("unchecked")
  public void setValue(
    Object value
    )
  {this.value = (TValue)value;}

  @Override
  public String toString(
    )
  {return getValue().toString();}
  // </public>

  // <protected>
  @Override
  protected Object clone(
    )
  {return super.clone();}
  // </protected>
  // </interface>
  // </dynamic>
  // </class>
}