<pre>
<code>
<span class="keyword">interface</span> Camion {
    <span class="keyword">val</span> color: <span class="types">String</span>
    <span class="keyword">fun</span> nroDeRuedas(): <span class="types">Int</span>
}

<span class="keyword">class</span> Isuzu(<span class="keyword">override val</span> color: <span class="types">String</span>) : Camion {
    <span class="keyword">override fun</span> nroDeRuedas(): <span class="types">Int</span> = 18
}

<span class="keyword">class</span> Benz(<span class="keyword">override val</span> color: String) : Camion {
    <span class="keyword">override fun</span> nroDeRuedas(): <span class="types">Int</span> = 22
}

<span class="keyword">class</span> JapanTruckFactory : CarFactory() {
    <span class="keyword">override fun</span> getTruck(): <span class="types">Camion</span> = Isuzu(<span class="arguments">color</span> = <span class="string">"White"</span>)
}

<span class="keyword">class</span> GermanTruckFactory : CarFactory() {
    <span class="keyword">override fun</span> getCamion(): <span class="types">Camion</span> = Benz(<span class="arguments">color</span> = <span class="string">"Black"</span>)
}

<span class="comments">//Fabrica Abstracta</span>
<span class="keyword">abstract class</span> CarFactory {

    <span class="keyword">abstract fun</span> getCamion(): <span class="types">Camion</span>

    <span class="keyword">companion object</span> {

        <span class="annotation">@JvmStatic</span>
        <span class="keyword">inline fun</span> <<span class="keyword">reified</span> <span class="generic">T</span>> createTruckFactory(): CarFactory {
            <span class="keyword">return when</span> (<span class="generic">T</span>::<span class="keyword">class</span>) {
                JapanTruckFactory::<span class="keyword">class</span> -> JapanTruckFactory()
                GermanTruckFactory::<span class="keyword">class</span> -> GermanTruckFactory()
                <span class="keyword">else</span> -> <span class="keyword">throw</span> IllegalStateException(<span class="string">"Unidentified truck factory"</span>)
            }
        }
    }
}

<span class="comments">//Uso: La interfaz genérica de la fábrica se utiliza para crear objetos concretos.</span>
<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> japanTruckFactory = CarFactory.createTruckFactory<<span class="types">JapanTruckFactory</span>>()
    <span class="keyword">val</span> germanTruckFactory = CarFactory.createTruckFactory<<span class="types">GermanTruckFactory</span>>()

    <span class="assertions">assert</span>(germanTruckFactory.getTruck() <span class="keyword">is</span> <span class="types">Benz</span>)<span class="comments">//True</span>
    <span class="assertions">assert</span>(japanTruckFactory.getTruck() <span class="keyword">is</span> <span class="types">Isuzu</span>)<span class="comments">//True</span>
}
</code>
</pre>