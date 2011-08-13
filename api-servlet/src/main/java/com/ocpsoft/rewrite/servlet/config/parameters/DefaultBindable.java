/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.rewrite.servlet.config.parameters;

import java.util.LinkedList;
import java.util.List;

import com.ocpsoft.rewrite.bind.Bindable;
import com.ocpsoft.rewrite.bind.Binding;

/**
 * Base {@link Bindable} implementation.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class DefaultBindable<T extends Bindable<T, B>, B extends Binding> implements Bindable<T, B>
{
   private final LinkedList<B> bindings = new LinkedList<B>();

   @Override
   @SuppressWarnings("unchecked")
   public T bindsTo(final B binding)
   {
      /*
       * Bindings must be added to the front of the list, since we want the 
       * ability to override the default binding if necessary.
       */
      this.bindings.addFirst(binding);
      return (T) this;
   }

   @Override
   public List<B> getBindings()
   {
      return bindings;
   }
}
