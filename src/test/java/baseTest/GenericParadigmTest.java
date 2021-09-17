package baseTest;

import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * @author duankd
 * @ClassName GenericParadigmTest
 * @date 2021-08-11 17:23:01
 */
public class GenericParadigmTest<T> {


    /**
     * 大并行查询列表
     */
    public <S extends T, V extends T> List<V> getListParallel(S search) {
        //List<V> list = this.getBaseDao().select(search);
        List<V> list = new ArrayList<>();
        //if(null !=list&& !list.isEmpty()){
        if (null != list) {
            List<V> results = new ArrayList<>();
            List<CompletableFuture<V>> futures = new ArrayList<>();
            list.forEach(new Consumer<V>() {
                @Override
                public void accept(V v) {
                    futures.add(CompletableFuture.supplyAsync(() -> traverse(v), new SimpleAsyncTaskExecutor()));
                }

                private <U> U traverse(V v) {
                    return null;
                }
            });
            //等待全部完成
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            for (CompletableFuture<V> future : futures) {
                try {
                    V v = future.get();
                    results.add(v);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return results;
        }
        return list;
    }

}
