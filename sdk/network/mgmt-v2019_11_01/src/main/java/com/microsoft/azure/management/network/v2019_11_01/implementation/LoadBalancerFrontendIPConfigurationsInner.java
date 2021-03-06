/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_11_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in LoadBalancerFrontendIPConfigurations.
 */
public class LoadBalancerFrontendIPConfigurationsInner {
    /** The Retrofit service to perform REST calls. */
    private LoadBalancerFrontendIPConfigurationsService service;
    /** The service client containing this operation class. */
    private NetworkManagementClientImpl client;

    /**
     * Initializes an instance of LoadBalancerFrontendIPConfigurationsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public LoadBalancerFrontendIPConfigurationsInner(Retrofit retrofit, NetworkManagementClientImpl client) {
        this.service = retrofit.create(LoadBalancerFrontendIPConfigurationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for LoadBalancerFrontendIPConfigurations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface LoadBalancerFrontendIPConfigurationsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.network.v2019_11_01.LoadBalancerFrontendIPConfigurations list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Network/loadBalancers/{loadBalancerName}/frontendIPConfigurations")
        Observable<Response<ResponseBody>> list(@Path("resourceGroupName") String resourceGroupName, @Path("loadBalancerName") String loadBalancerName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.network.v2019_11_01.LoadBalancerFrontendIPConfigurations get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Network/loadBalancers/{loadBalancerName}/frontendIPConfigurations/{frontendIPConfigurationName}")
        Observable<Response<ResponseBody>> get(@Path("resourceGroupName") String resourceGroupName, @Path("loadBalancerName") String loadBalancerName, @Path("frontendIPConfigurationName") String frontendIPConfigurationName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.network.v2019_11_01.LoadBalancerFrontendIPConfigurations listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;FrontendIPConfigurationInner&gt; object if successful.
     */
    public PagedList<FrontendIPConfigurationInner> list(final String resourceGroupName, final String loadBalancerName) {
        ServiceResponse<Page<FrontendIPConfigurationInner>> response = listSinglePageAsync(resourceGroupName, loadBalancerName).toBlocking().single();
        return new PagedList<FrontendIPConfigurationInner>(response.body()) {
            @Override
            public Page<FrontendIPConfigurationInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<FrontendIPConfigurationInner>> listAsync(final String resourceGroupName, final String loadBalancerName, final ListOperationCallback<FrontendIPConfigurationInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(resourceGroupName, loadBalancerName),
            new Func1<String, Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;FrontendIPConfigurationInner&gt; object
     */
    public Observable<Page<FrontendIPConfigurationInner>> listAsync(final String resourceGroupName, final String loadBalancerName) {
        return listWithServiceResponseAsync(resourceGroupName, loadBalancerName)
            .map(new Func1<ServiceResponse<Page<FrontendIPConfigurationInner>>, Page<FrontendIPConfigurationInner>>() {
                @Override
                public Page<FrontendIPConfigurationInner> call(ServiceResponse<Page<FrontendIPConfigurationInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;FrontendIPConfigurationInner&gt; object
     */
    public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> listWithServiceResponseAsync(final String resourceGroupName, final String loadBalancerName) {
        return listSinglePageAsync(resourceGroupName, loadBalancerName)
            .concatMap(new Func1<ServiceResponse<Page<FrontendIPConfigurationInner>>, Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> call(ServiceResponse<Page<FrontendIPConfigurationInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
    ServiceResponse<PageImpl<FrontendIPConfigurationInner>> * @param resourceGroupName The name of the resource group.
    ServiceResponse<PageImpl<FrontendIPConfigurationInner>> * @param loadBalancerName The name of the load balancer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;FrontendIPConfigurationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> listSinglePageAsync(final String resourceGroupName, final String loadBalancerName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (loadBalancerName == null) {
            throw new IllegalArgumentException("Parameter loadBalancerName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2019-11-01";
        return service.list(resourceGroupName, loadBalancerName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<FrontendIPConfigurationInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<FrontendIPConfigurationInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<FrontendIPConfigurationInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<FrontendIPConfigurationInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<FrontendIPConfigurationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets load balancer frontend IP configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @param frontendIPConfigurationName The name of the frontend IP configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the FrontendIPConfigurationInner object if successful.
     */
    public FrontendIPConfigurationInner get(String resourceGroupName, String loadBalancerName, String frontendIPConfigurationName) {
        return getWithServiceResponseAsync(resourceGroupName, loadBalancerName, frontendIPConfigurationName).toBlocking().single().body();
    }

    /**
     * Gets load balancer frontend IP configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @param frontendIPConfigurationName The name of the frontend IP configuration.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<FrontendIPConfigurationInner> getAsync(String resourceGroupName, String loadBalancerName, String frontendIPConfigurationName, final ServiceCallback<FrontendIPConfigurationInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, loadBalancerName, frontendIPConfigurationName), serviceCallback);
    }

    /**
     * Gets load balancer frontend IP configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @param frontendIPConfigurationName The name of the frontend IP configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the FrontendIPConfigurationInner object
     */
    public Observable<FrontendIPConfigurationInner> getAsync(String resourceGroupName, String loadBalancerName, String frontendIPConfigurationName) {
        return getWithServiceResponseAsync(resourceGroupName, loadBalancerName, frontendIPConfigurationName).map(new Func1<ServiceResponse<FrontendIPConfigurationInner>, FrontendIPConfigurationInner>() {
            @Override
            public FrontendIPConfigurationInner call(ServiceResponse<FrontendIPConfigurationInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets load balancer frontend IP configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param loadBalancerName The name of the load balancer.
     * @param frontendIPConfigurationName The name of the frontend IP configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the FrontendIPConfigurationInner object
     */
    public Observable<ServiceResponse<FrontendIPConfigurationInner>> getWithServiceResponseAsync(String resourceGroupName, String loadBalancerName, String frontendIPConfigurationName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (loadBalancerName == null) {
            throw new IllegalArgumentException("Parameter loadBalancerName is required and cannot be null.");
        }
        if (frontendIPConfigurationName == null) {
            throw new IllegalArgumentException("Parameter frontendIPConfigurationName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2019-11-01";
        return service.get(resourceGroupName, loadBalancerName, frontendIPConfigurationName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<FrontendIPConfigurationInner>>>() {
                @Override
                public Observable<ServiceResponse<FrontendIPConfigurationInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<FrontendIPConfigurationInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<FrontendIPConfigurationInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<FrontendIPConfigurationInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<FrontendIPConfigurationInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;FrontendIPConfigurationInner&gt; object if successful.
     */
    public PagedList<FrontendIPConfigurationInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<FrontendIPConfigurationInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<FrontendIPConfigurationInner>(response.body()) {
            @Override
            public Page<FrontendIPConfigurationInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<FrontendIPConfigurationInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<FrontendIPConfigurationInner>> serviceFuture, final ListOperationCallback<FrontendIPConfigurationInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;FrontendIPConfigurationInner&gt; object
     */
    public Observable<Page<FrontendIPConfigurationInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<FrontendIPConfigurationInner>>, Page<FrontendIPConfigurationInner>>() {
                @Override
                public Page<FrontendIPConfigurationInner> call(ServiceResponse<Page<FrontendIPConfigurationInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;FrontendIPConfigurationInner&gt; object
     */
    public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<FrontendIPConfigurationInner>>, Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> call(ServiceResponse<Page<FrontendIPConfigurationInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all the load balancer frontend IP configurations.
     *
    ServiceResponse<PageImpl<FrontendIPConfigurationInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;FrontendIPConfigurationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<FrontendIPConfigurationInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<FrontendIPConfigurationInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<FrontendIPConfigurationInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<FrontendIPConfigurationInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<FrontendIPConfigurationInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<FrontendIPConfigurationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
