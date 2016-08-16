package adl.test5;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.adl.runtime.Factories;
import org.adl.runtime.Factory;
import org.adl.runtime.JsonBinding;
import org.adl.runtime.JsonBindings;
import java.util.Map;
import java.util.Objects;

public class U9<T> {

  /* Members */

  private Disc disc;
  private Object value;

  /**
   * The U9 discriminator type.
   */
  public enum Disc {
    V1,
    V2
  }

  /* Constructors */

  public static <T> U9<T> v1(T v) {
    return new U9<T>(Disc.V1, Objects.requireNonNull(v));
  }

  public static <T> U9<T> v2(short v) {
    return new U9<T>(Disc.V2, v);
  }

  private U9(Disc disc, Object value) {
    this.disc = disc;
    this.value = value;
  }

  /* Accessors */

  public Disc getDisc() {
    return disc;
  }

  public T getV1() {
    if (disc == Disc.V1) {
      return U9.<T>cast(value);
    }
    throw new IllegalStateException();
  }

  public short getV2() {
    if (disc == Disc.V2) {
      return (Short) value;
    }
    throw new IllegalStateException();
  }

  /* Mutators */

  public void setV1(T v) {
    this.value = Objects.requireNonNull(v);
    this.disc = Disc.V1;
  }

  public void setV2(short v) {
    this.value = v;
    this.disc = Disc.V2;
  }

  /* Object level helpers */

  @Override
  public boolean equals(Object other0) {
    if (!(other0 instanceof U9)) {
      return false;
    }
    U9 other = (U9) other0;
    return disc == other.disc && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    return disc.hashCode() * 37 + value.hashCode();
  }

  @SuppressWarnings("unchecked")
  private static <T> T cast(final Object o) {
    return (T) o;
  }

  /* Factory for construction of generic values */

  public static <T> Factory<U9 <T>> factory(Factory<T> factoryT) {
    return new Factory<U9<T>>() {
      final Factory<T> v1 = factoryT;
      final Factory<Short> v2 = Factories.SHORT;

      public U9<T> create() {
        return new U9<T>(Disc.V1,v1.create());
      }

      public U9<T> create(U9<T> other) {
        switch (other.disc) {
          case V1:
            return new U9<T>(other.disc,v1.create(U9.<T>cast(other.value)));
          case V2:
            return new U9<T>(other.disc,other.value);
        }
        throw new IllegalArgumentException();
      }
    };
  }

  /* Json serialization */

  public static<T> JsonBinding<U9<T>> jsonBinding(JsonBinding<T> bindingT) {
    final JsonBinding<T> v1 = bindingT;
    final JsonBinding<Short> v2 = JsonBindings.SHORT;
    final Factory<T> factoryT = bindingT.factory();
    final Factory<U9<T>> _factory = factory(bindingT.factory());

    return new JsonBinding<U9<T>>() {
      public Factory<U9<T>> factory() {
        return _factory;
      }

      public JsonElement toJson(U9<T> _value) {
        JsonObject _result = new JsonObject();
        switch (_value.getDisc()) {
          case V1:
            _result.add("v1", v1.toJson(_value.getV1()));
            break;
          case V2:
            _result.add("v2", v2.toJson(_value.getV2()));
            break;
        }
        return _result;
      }

      public U9<T> fromJson(JsonElement _json) {
        JsonObject _obj = _json.getAsJsonObject();
        for (Map.Entry<String,JsonElement> _v : _obj.entrySet()) {
          if (_v.getKey() == "v1") {
            return U9.<T>v1(v1.fromJson(_v.getValue()));
          }
          else if (_v.getKey() == "v2") {
            return U9.<T>v2(v2.fromJson(_v.getValue()));
          }
        }
        throw new IllegalStateException();
      }
    };
  }
}